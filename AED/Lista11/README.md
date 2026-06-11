Lista11 - Buscas (simples)
=================================

Este package contém implementações e um pequeno programa de demonstração
para a lista L11 - Buscas (simples).

Arquivos:
- src/Lista11/BuscaSimples.java — Busca linear
- src/Lista11/BuscaBinariaIterativa.java — Busca binária (iterativa)
- src/Lista11/BuscaBinariaRecursiva.java — Busca binária (recursiva)
- src/Lista11/Main.java — Programa demonstrativo
 - src/test/java/Lista11/*Test.java — Testes JUnit (4)

Como compilar e executar (PowerShell):

cd "C:\Users\P.Luna\Desktop\faculdadebcc\AED\Lista11"
javac -d out -sourcepath src src\Lista11\*.java
java -cp out Lista11.Main

Executando os testes JUnit
 - Os testes de unidade foram escritos usando JUnit 4. Para executá-los você pode:
   * Abrir o projeto no IntelliJ/NetBeans/Eclipse e executar as classes de teste (IDE gerencia a dependência automaticamente);
   * Ou usar o jar do JUnit manualmente. Exemplo (supondo que você tenha baixado junit-4.13.2.jar e hamcrest-core-1.3.jar para a pasta lib):

	cd "C:\Users\P.Luna\Desktop\faculdadebcc\AED\Lista11"
	javac -d out -sourcepath src -cp lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar src\Lista11\*.java src\test\java\Lista11\*Test.java
	java -cp out;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar org.junit.runner.JUnitCore Lista11.BuscaSimplesTest

Explicações (apenas neste README)
 - Busca linear (BuscaSimples): percorre o array do início ao fim verificando igualdade com a chave. Complexidade: O(n) no pior caso; uso de memória O(1).
 - Busca binária iterativa (BuscaBinariaIterativa): em arrays ordenados procura dividindo o intervalo pela metade repetidamente (lo/hi). Complexidade: O(log n); uso de memória O(1).
 - Busca binária recursiva (BuscaBinariaRecursiva): mesma ideia da binária, implementada de forma recursiva. Complexidade: O(log n); uso de memória O(log n) devido à pilha de chamadas.

Notas
 - As implementações trabalham com arrays de int para simplicidade pedagógica.
 - Os testes cobrem casos típicos: array nulo, array vazio, chave presente e ausente, e duplicatas para busca linear.

Observações:
- A busca binária requer que o array esteja ordenado (ordenação crescente).
- Este projeto usa apenas arrays de int para manter o código simples para fins de estudo.


