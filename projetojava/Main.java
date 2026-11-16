import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("     🔥 O DESTINO DA TERRA MÉDIA 🔥     ");
        System.out.println("========================================");
        System.out.println("Você chegou aos portões de Barad-dûr...");
        System.out.println("Sauron desce de seu trono para enfrentá-lo!");

        Combatente heroi = criarPersonagem(scanner); 

        escolherItens(scanner, heroi);

        System.out.println("\n⚔️ Deseja treinar antes de enfrentar Sauron?");
        System.out.println("1 - Sim (Enfrentar Orcs para ganhar XP)");
        System.out.println("2 - Não (Ir direto para o Boss)");
        System.out.print("Escolha: ");
        
        while (!scanner.hasNextInt()) { 
            System.out.print("Digite 1 ou 2: ");
            scanner.next(); 
        }
        int escolhaTreino = scanner.nextInt();
        
        if (escolhaTreino == 1) {
            boolean treinando = true;
            
            while (treinando && heroi.estaVivo()) {
                // Cria um inimigo para treino (Nível 1)
                Combatente orc = new Orque("Orc Batedor", 1); 
                orc.equiparArma(new Machado()); 
                
                System.out.println("\n>>> Um Orc selvagem apareceu! <<<");
                Batalha treino = new Batalha(heroi, orc);
                treino.iniciar();
                
                if (heroi.estaVivo()) {
                    System.out.println("\nO que deseja fazer?");
                    System.out.println("1 - Continuar treinando (Novo Orc)");
                    System.out.println("2 - Ir para Sauron (Chega de treino)");
                    System.out.print("Escolha: ");
                    
                    while (!scanner.hasNextInt()) { scanner.next(); }
                    int op = scanner.nextInt();
                    
                    if (op == 2) treinando = false;
                }
            }
        }

        if (!heroi.estaVivo()) {
            System.out.println("\n☠️ Você morreu durante o treinamento... Fim de jogo.");
            scanner.close();
            return;
        }

        System.out.println("\n⚡ Você sente uma presença terrível... Sauron chegou!");
        
        Combatente boss = new Sauron("Sauron, o Senhor do Escuro", 1); 
        
        Batalha duelo = new Batalha(heroi, boss);
        duelo.iniciar();

        if (heroi.estaVivo()) {
            System.out.println("\n🌌 O chão treme... Uma sombra antiga desperta com a queda de Sauron.");
            System.out.println("MORGOTH, o Primeiro Senhor do Escuro, retorna do Vazio!");
            System.out.println("\nDeseja enfrentar o desafio final com seu herói Nível " + heroi.getNivel() + "?");
            System.out.println("1 - SIM (A Batalha Final de Verdade)");
            System.out.println("2 - NÃO (Aposentar-se como lenda)");
            System.out.print("Escolha: ");
            
            while (!scanner.hasNextInt()) { scanner.next(); }
            int escolhaFinal = scanner.nextInt();

            if (escolhaFinal == 1) {
                Combatente morgoth = new Sauron("Morgoth, o Inimigo do Mundo", 10);
                morgoth.equiparArma(new Machado()); 

                System.out.println("\n⚔️ PREPARE-SE! A ÚLTIMA BATALHA COMEÇA AGORA!");
                Batalha batalhaFinal = new Batalha(heroi, morgoth);
                batalhaFinal.iniciar();
            } else {
                System.out.println("\nVocê guardou sua espada e viveu em paz na Terra Média.");
            }
        }
        
        scanner.close(); 
    }

    public static Combatente criarPersonagem(Scanner scanner) {
        System.out.println("\n>>> PREPARAÇÃO DO HERÓI <<<");
        
        System.out.print("Digite seu nome: ");
        String nome = scanner.next();

        System.out.println("Escolha sua Classe:");
        System.out.println("1 - Humano");
        System.out.println("2 - Mago");
        System.out.println("3 - Elfo");
        System.out.println("4 - Anão"); 
        System.out.println("5 - Hobbit");
        System.out.print("Escolha: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Digite o NÚMERO: ");
            scanner.next();
        }
        int tipo = scanner.nextInt();
        
        System.out.println("\n🎲 Rolando dados de atributos...");
        try { Thread.sleep(1000); } catch (Exception e) {} 

        Combatente heroi;
        int nivelInicial = 1;

        switch (tipo) {
            case 1: heroi = new Humano(nome, nivelInicial); break;
            case 2: heroi = new Mago(nome, nivelInicial); break;
            case 3: heroi = new Elfo(nome, nivelInicial); break;
            case 4: heroi = new Anao(nome, nivelInicial); break; 
            case 5: heroi = new Hobbit(nome, nivelInicial); break;
            default: heroi = new Humano(nome, nivelInicial);
        }

        heroi.mostrarFicha();

        System.out.println("\nEscolha sua arma para o combate final:");
        Arma arma = escolherArma(scanner); 
        heroi.equiparArma(arma);

        return heroi;
    }

    public static Arma escolherArma(Scanner scanner) {
        System.out.println("1 - Espada (Dano Equilibrado)");
        System.out.println("2 - Machado (Dano Variável)");
        System.out.println("3 - Cajado (Magia)");
        System.out.println("4 - Arco (Ataque à Distância)");
        System.out.print("Arma: ");
        
        while (!scanner.hasNextInt()) {
            System.out.print("Digite o NÚMERO: ");
            scanner.next();
        }
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1: return new Espada();
            case 2: return new Machado();
            case 3: return new Cajado();
            case 4: return new Arco();
            default: return new Espada();
        }
    }

    public static void escolherItens(Scanner scanner, Combatente heroi) {
        System.out.println("\n🎁 --- SUPRIMENTOS DE GUERRA ---");
        
        boolean escolhendo = true;

        while (escolhendo) {
            // 1. MOSTRA O ESTADO ATUAL DA MOCHILA
            int qtdAtual = heroi.getItens().size();
            int capacidadeMax = 10; // Definimos 10 como limite no Combatente
            
            System.out.println("\n┌──────────────────────────────────────────┐");
            System.out.printf("│ 🎒 MOCHILA ATUAL: %-2d / %-2d                  │\n", qtdAtual, capacidadeMax);
            System.out.println("├──────────────────────────────────────────┤");
            
            if (qtdAtual == 0) {
                System.out.println("│ (Vazia)                                  │");
            } else {
                for (Item item : heroi.getItens()) {
                    System.out.printf("│ > %-38s │\n", item.getNome());
                }
            }
            System.out.println("└──────────────────────────────────────────┘");

            // 2. MOSTRA AS OPÇÕES
            System.out.println("\nItens disponíveis para pegar:");
            System.out.println("1 - Poção de Vida   (+30 HP)");
            System.out.println("2 - Poção de Força  (+10 ATK)");
            System.out.println("3 - Poção de Defesa (+10 DEF)");
            System.out.println("0 - Terminar e Ir para a Batalha");
            System.out.print("Escolha um item: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Digite um número: ");
                scanner.next();
            }
            int escolha = scanner.nextInt();

            if (escolha == 0) {
                escolhendo = false;
            } else if (escolha >= 1 && escolha <= 3) {
                
                // Só adiciona se tiver espaço (Verificação visual aqui, mas o Combatente tbm barra)
                if (qtdAtual < capacidadeMax) {
                    if (escolha == 1) heroi.adicionarItem(new PocaoVida());
                    if (escolha == 2) heroi.adicionarItem(new PocaoForca());
                    if (escolha == 3) heroi.adicionarItem(new PocaoDefesa());
                } else {
                    System.out.println("❌ A mochila já está cheia! Remova itens ou vá lutar.");
                    // Pausa rápida para ler a mensagem de erro
                    try { Thread.sleep(1000); } catch (Exception e) {}
                }

            } else {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("\n🎒 Mochila fechada! Rumo à batalha!");
    }
}