# 🏦 Simulador de Atendimento Bancário — Java

Trabalho acadêmico sobre **Estruturas de Dados Lineares e Não Lineares** implementadas do zero em Java (sem uso de `ArrayList`, `LinkedList`, `Queue`, `Stack`, `HashMap` ou qualquer coleção nativa do Java).

---

## 📁 Estrutura do Projeto

```
src/
├── Main.java                          ← Ponto de entrada
├── modelo/
│   └── RegistroAtendimento.java       ← Entidade central (cliente/atendimento)
├── estruturas/
│   ├── No.java                        ← Nó genérico encadeado
│   ├── Fila.java                      ← Fila genérica FIFO (lista encadeada)
│   └── Pilha.java                     ← Pilha genérica LIFO (lista encadeada)
├── guiches/
│   ├── Guiche.java                    ← Classe abstrata base dos guichês
│   ├── AtendimentoPreferencial.java   ← Guichê preferencial
│   └── AtendimentoGeral.java          ← Guichê geral (com alternância)
├── util/
│   └── Ordenacao.java                 ← MergeSort e QuickSort manuais
└── sistema/
    ├── Relatorio.java                 ← Gerador de relatórios com métricas
    └── SimuladorBanco.java            ← Orquestrador e menu do console
```

---

## ▶️ Como Compilar e Executar

### Pré-requisito
- Java JDK 11 ou superior instalado
- Verificar com: `java -version`

### Compilação
```bash
# A partir da raiz do projeto (onde está a pasta src/)
mkdir -p out

javac -encoding UTF-8 -d out -sourcepath src \
  src/estruturas/*.java \
  src/modelo/*.java \
  src/guiches/*.java \
  src/util/*.java \
  src/sistema/*.java \
  src/Main.java
```

### Execução
```bash
java -cp out Main
```

### Compilação e execução em um único comando (Linux/Mac)
```bash
mkdir -p out && \
javac -encoding UTF-8 -d out -sourcepath src src/estruturas/*.java src/modelo/*.java \
  src/guiches/*.java src/util/*.java src/sistema/*.java src/Main.java && \
java -cp out Main
```

### Windows (PowerShell)
```powershell
mkdir out
javac -encoding UTF-8 -d out -sourcepath src src\estruturas\*.java src\modelo\*.java `
  src\guiches\*.java src\util\*.java src\sistema\*.java src\Main.java
java -cp out Main
```

---

## 🧭 Guia Rápido de Uso (Menu)

| Opção | Ação |
|-------|------|
| 1 | Adicionar cliente **Prioritário** (informar tempo de atendimento) |
| 2 | Adicionar cliente **Normal** |
| 3 | Adicionar **N clientes aleatórios** (tipos e tempos sorteados) |
| 4 | Chamar próximo — **Guichê Preferencial** |
| 5 | Chamar próximo — **Guichê Geral 1** |
| 6 | Chamar próximo — **Guichê Geral 2** |
| 7 | Chamar próximo — **alternando Geral 1/2** |
| 8 | **Atender todos** em lote (esvazia as filas) |
| 9 | Ver **status** das filas e histórico dos guichês |
| 10 | **Avançar relógio** manualmente (em minutos) |
| 11 | Gerar **relatório final** completo |
| 0 | Sair |

### Fluxo típico de simulação
```
1. Adicionar 10 clientes aleatórios (opção 3)
2. Atender todos em lote (opção 8)
3. Gerar relatório (opção 11)
```

---

## 🏗️ Arquitetura das Classes

### `modelo/RegistroAtendimento`
Entidade de domínio que representa **um cliente e seu atendimento completo**.
Armazena: `idCliente`, `horarioChegada`, `tempoAtendimento`, `tipoCliente` (enum PRIORITARIO/NORMAL), `horarioInicioAtendimento`, `horarioFimAtendimento`, `tempoEspera`, `nomeGuiche`.  
O método `iniciarAtendimento(horario, guiche)` é chamado pelo guichê e calcula automaticamente espera e fim.

### `estruturas/No<T>`
Nó genérico com `dado: T` e `proximo: No<T>`. Building block de Fila e Pilha.

### `estruturas/Fila<T>`
Lista encadeada simples com ponteiros `inicio` e `fim`.  
- `enqueue(T)` — insere no fim: O(1)  
- `dequeue()` — remove do início: O(1)  
- `peek()` — consulta o início sem remover: O(1)

### `estruturas/Pilha<T>`
Lista encadeada com ponteiro `topo`.  
- `push(T)` — empilha no topo: O(1)  
- `pop()` — desempilha do topo: O(1)  
- `toArray()` — snapshot para relatório: O(n)

### `guiches/Guiche` (abstrata)
Template Method Pattern: define `chamarProximo()` com lógica comum (registrar no histórico, atualizar contadores) e delega `selecionarProximoCliente()` às subclasses.

### `guiches/AtendimentoPreferencial`
**Sempre** consome da FilaPrioritária. Só usa FilaNormal quando a prioritária está vazia.

### `guiches/AtendimentoGeral`
Mantém flag `proximoDeveSerNormal` para **alternar** entre filas e evitar starvation dos clientes normais. A cada prioritário atendido, o próximo é normal (se disponível).

### `util/Ordenacao`
- **MergeSort** — estável, O(n log n): usado para ordenar por tempo de espera crescente.  
- **QuickSort** — in-place, O(n log n) médio: usado para ordenar por horário de atendimento.  
Ambos operam sobre `RegistroAtendimento[]` com critérios distintos.

### `sistema/Relatorio`
Agrega os históricos de todos os guichês (via `Pilha.toArray()`), calcula métricas (totais, médias) e exibe dois rankings com MergeSort e QuickSort.

### `sistema/SimuladorBanco`
Orquestrador central: mantém as duas `Fila<RegistroAtendimento>` compartilhadas, os três guichês, o relógio da simulação (em minutos desde 08:00) e o menu de console.

---

## 📊 Estruturas de Dados Utilizadas

| Estrutura | Uso | Tipo |
|-----------|-----|------|
| `Fila<RegistroAtendimento>` | FilaPrioritária e FilaNormal | Linear / Encadeada |
| `Pilha<RegistroAtendimento>` | Histórico por guichê | Linear / Encadeada |
| `No<T>` | Nó de Fila e Pilha | Auxiliar |
| `RegistroAtendimento[]` | Base para ordenação | Array simples |
| MergeSort / QuickSort | Ordenação no relatório | Algoritmos |

---

## ✅ Critérios Atendidos

- [x] Fila FIFO implementada manualmente com lista encadeada
- [x] Pilha LIFO implementada manualmente com lista encadeada
- [x] Nenhuma coleção Java nativa usada para armazenar atendimentos
- [x] Guichê preferencial com regra correta de prioridade
- [x] Guichês gerais com alternância para evitar starvation
- [x] Histórico de atendimentos em pilha por guichê
- [x] MergeSort manual (por tempo de espera)
- [x] QuickSort manual (por horário de atendimento)
- [x] Relatório com todos os itens solicitados
- [x] Horários representados em minutos com formatação hh:mm
- [x] Menu de console funcional
- [x] Código comentado e bem organizado
