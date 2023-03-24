package Controller;

import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {

	private Semaphore semaforonorte;
	private Semaphore semaforosul;
	private int idAviao;

	// Construtor passando os semaforos e as threads.
	public ThreadAeroporto(int idAvião, Semaphore semaforonorte, Semaphore semaforosul) {
		this.semaforonorte = semaforonorte;
		this.semaforosul = semaforosul;
		this.idAviao = idAvião;
	}

	// Método Run pra rodar as threads
		@Override
		public void run() {
		decolagem();
		}

		private void decolagem() {
	// Declaração dos tempos 
			int manobra = (int) (Math.random() * 2700) + 3000;
			int taxiar = (int) (Math.random() * 2) + 4999;
			int decolagem = (int) (Math.random() * 5) + 1000;
			int afastamento = (int) (Math.random() * 3) + 3000;
			
			int pista = (int) (Math.random() * 1.5) + 1;
			
			switch(pista) {
			
	// Switch pra definir as pistas e as operações
			case 1: 
				try {
					semaforonorte.acquire();
					System.out.println("Avião "+idAviao+" está circulando na pista Norte");
					System.out.println("Irá fazer o pouso agora");
					System.out.println("Pouso realizado");
					System.out.println("Começando a fase de taxiamento");
					sleep(taxiar);
					System.out.println("Taxiamento realizado");
					System.out.println("Preparando para a decolagem ");
					sleep(decolagem);
					System.out.println("Decolagem realizada");
					System.out.println("Aguarde o afastamento para outro avião entrar na pista");
					sleep(afastamento);
					System.out.println("Afastamento realizado. Pista liberada");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaforonorte.release();
				}
			case 2: 
				try {
					semaforosul.acquire();
					System.out.println("Avião "+idAviao+" está circulando na pista sul");
					System.out.println("Irá fazer o pouso agora");
					sleep(manobra);
					System.out.println("Pouso realizado");
					System.out.println("Começando a fase de taxiamento");
					sleep(taxiar);
					System.out.println("Taxiamento realizado");
					System.out.println("Preparando para a decolagem ");
					sleep(decolagem);
					System.out.println("Decolagem realizada");
					System.out.println("Aguarde o afastamento para outro avião entrar na pista");
					sleep(afastamento);
					System.out.println("Afastamento realizado. Pista liberada");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaforosul.release();
				}
			}

}
		
		
		
		
}