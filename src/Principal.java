import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    public static void removerFuncionarioPorNome(List<Funcionario> funcionarios, String nome) {
        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (funcionario.getNome().equals(nome)) {
                iterator.remove();
                System.out.println("Funcionário " + nome + " removido da lista.");
                return;
            }
        }
        System.out.println("Funcionário " + nome + " não encontrado na lista.");
    }
    public static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Funcionario funcionario : funcionarios) {
            String dataFormatada = funcionario.getDataNascimento().format(formatter);
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + dataFormatada);
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println("--------------------------");
        }
    }
    public static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numberFormatter = NumberFormat.getInstance(new Locale("pt", "BR"));
        numberFormatter.setMinimumFractionDigits(2);
        numberFormatter.setMaximumFractionDigits(2);

        for (Funcionario funcionario : funcionarios) {
            String dataFormatada = funcionario.getDataNascimento().format(dateFormatter);
            String salarioFormatado = numberFormatter.format(funcionario.getSalario());

            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + dataFormatada);
            System.out.println("Salário: " + salarioFormatado);
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println("--------------------------");
        }
    }
    public static void atualizarSalario(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(BigDecimal.valueOf(0.10));
            BigDecimal novoSalario = salarioAtual.add(aumento);
            funcionario.setSalario(novoSalario);
        }
    }
    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }
    public static void imprimirFuncionariosPorFuncao(List<Funcionario> funcionarios) {
        // Map para agrupar funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        // Agrupando os funcionários
        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();
            // Se a função ainda não estiver no map, criar uma nova lista vazia
            funcionariosPorFuncao.putIfAbsent(funcao, new ArrayList<>());
            // Adicionar o funcionário na lista correspondente à função
            funcionariosPorFuncao.get(funcao).add(funcionario);
        }

        public static void imprimirAniversariantes(List<Funcionario> funcionarios, Month... meses) {
            // Lista para armazenar os funcionários que fazem aniversário nos meses especificados
            List<Funcionario> aniversariantes = new ArrayList<>();

            // Obtendo os meses desejados em formato de Set para verificação eficiente
            Set<Month> mesesDesejados = new HashSet<>(Arrays.asList(meses));

            // Filtrando os funcionários cujo mês de aniversário está na lista de meses desejados
            for (Funcionario funcionario : funcionarios) {
                Month mesAniversario = funcionario.getDataNascimento().getMonth();
                if (mesesDesejados.contains(mesAniversario)) {
                    aniversariantes.add(funcionario);
                }
            }

            // Imprimindo os funcionários que fazem aniversário nos meses especificados
            System.out.println("Funcionários que fazem aniversário nos meses " + Arrays.toString(meses) + ":");
            for (Funcionario funcionario : aniversariantes) {
                System.out.println(funcionario);
            }
        }

// Encontrar e imprimir o funcionário com maior idade
        Funcionario funcionarioMaisVelho = encontrarFuncionarioMaisVelho(funcionarios);
        if (funcionarioMaisVelho != null) {
            int idade = calcularIdade(funcionarioMaisVelho.getDataNascimento());
            System.out.println("Funcionário mais velho:");
            System.out.println("Nome: " + funcionarioMaisVelho.getNome());
            System.out.println("Idade: " + idade);
        } else {
            System.out.println("Não foi possível determinar o funcionário mais velho.");
        }
    }

    public static Funcionario encontrarFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            return null;
        }

        public static void ordenarFuncionariosPorNome(List<Funcionario> funcionarios) {
            // Utiliza um Comparator para ordenar por nome
            Comparator<Funcionario> comparadorPorNome = Comparator.comparing(Funcionario::getNome);
            Collections.sort(funcionarios, comparadorPorNome);
        }

        public static double calcularTotalSalarios(List<Funcionario> funcionarios) {
            double total = 0;
            for (Funcionario funcionario : funcionarios) {
                total += funcionario.getSalario();
            }
            return total;
        }
        System.out.println("Quantidade de salários mínimos que cada funcionário ganha:");
        for (Funcionario funcionario : funcionarios) {
            double quantSalariosMinimos = funcionario.getSalario() / salarioMinimo;
            System.out.println(funcionario.getNome() + ": " + quantSalariosMinimos + " salários mínimos");
        }
    }


}

