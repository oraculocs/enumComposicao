package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entity.Departamento;
import entity.HourContract;
import entity.Worker;
import enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		/*
		 * Ler os dados de um trabalhador com N contratos (N fornecido pelo usu�rio). Depois, solicitar
		 * do usu�rio um m�s e mostrar qual foi o sal�rio do funcion�rio nesse m�s.
		 */

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Nome trabalhador: ");
		String nome = sc.nextLine();
		
		System.out.println("N�vel do Trabalhador");
		String nivel = sc.nextLine();
		
		System.out.println("Sal�rio Base do Trabalhador: ");
		Double salario = sc.nextDouble();
		
		Worker worker = new Worker(nome, WorkerLevel.valueOf(nivel), salario, new Departamento(nomeDepartamento));
		
		System.out.println("Quantos contratos esse trabalhador tem?");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Entre com a Data (DD/MM/YYYY):");
			Date dataContrato = sdf.parse(sc.next());
			System.out.println("Valor por Hora: ");
			double valorHora = sc.nextDouble();
			System.out.println("Dura��o do Contrato: ");
			int hora = sc.nextInt();
			
			HourContract contract = new HourContract(dataContrato, valorHora, hora);
			
			worker.addContract(contract);
			
			
		}
		
		System.out.println();
		System.out.println("Entre com o m�s e o ano para calcular o sal�rio (MM/YYYY)");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " + worker.getNome());
		System.out.println("Departamento: " + worker.getDepartment().getNome());
		System.out.println("Renda para: " + mesAno + ": " + String.format("%.2f", worker.income(ano, mes)));
		
		sc.close();
	}

}
