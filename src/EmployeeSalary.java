import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos funcionários serão cadastrados? ");
        int n = sc.nextInt();

        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nFuncionário #" + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            boolean idExistente = false;
            for (Funcionario func : funcionarios) {
                if (func.getId() == id) {
                    idExistente = true;
                    break;
                }
            }

            if (idExistente) {
                System.out.println("ID já existe. Informe um ID diferente.");
                i--;
                continue;
            }

            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Salário: R$");
            double salario = sc.nextDouble();

            Funcionario funcionario = new Funcionario(id, nome, salario);
            funcionarios.add(funcionario);
        }

        System.out.println("\nLista de Funcionários:");
        for (Funcionario func : funcionarios) {
            System.out.println(func);
        }

        System.out.println("\nInforme o ID do funcionário para aumento de salário: ");
        int idAumento = sc.nextInt();

        boolean encontrado = false;
        for (Funcionario func : funcionarios) {
            if (func.getId() == idAumento) {
                System.out.print("Informe a porcentagem de aumento: ");
                double percentualAumento = sc.nextDouble();
                func.aumentarSalario(percentualAumento);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("ID não encontrado. Operação cancelado.");
        }

        System.out.println("\nLista de Funcionários atualizada:");
        for (Funcionario func : funcionarios) {
            System.out.println(func);
        }
        sc.close();
    }
}