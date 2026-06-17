## Lista 11 - Buscas e Árvores Binárias

Solução completa proposta para a Lista 11 de Estruturas de Dados com código refatorado usando **Generics** e **Orientação a Objetos**.

### Estrutura do Projeto

```
Lista11/
├── src/
│   └── Lista11/
│       ├── BuscaAbstract.java
│       ├── BuscaLinear.java
│       ├── BuscaBinaria.java
│       ├── BuscaLinearVetorOrdenado.java
│       ├── TesteBuscas.java
│       ├── NoArvoreBinaria.java
│       ├── ArvoreBinariaAbstract.java
│       ├── ArvoreBinaria.java
│       ├── ArvoreBinariaBusca.java
│       ├── TesteArvore.java
│       └── Main.java (existente)
└── README.md
```

---

## PARTE 1: Algoritmos de Busca

### 1. **BuscaAbstract.java**
Classe abstrata base para todos os algoritmos de busca.

**Características:**
- Atributo privado `info` do tipo `Object[]`
- Métodos `getInfo()` e `setInfo(Object[] info)`
- Método abstrato `buscar(T valor)` que deve ser implementado pelas subclasses

**Padrão:** Template Method + Strategy Pattern

---

### 2. **BuscaLinear.java**
Implementação de **Busca Linear (Sequencial)**.

```java
public class BuscaLinear<T> extends BuscaAbstract<T>
```

**Características:**
- Realiza busca sequencial em qualquer tipo de dado
- Usa `equals()` para comparação
- Retorna o índice da primeira ocorrência ou -1
- **Complexidade:** O(n)
- **Não requer:** Ordenação
- **Uso:** Dados desordenados ou pequenos volumes

---

### 3. **BuscaBinaria.java**
Implementação de **Busca Binária (Clássica)**.

```java
public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract<T>
```

**Características:**
- Realiza busca binária aproveitando ordem dos dados
- Usa `compareTo()` para comparação
- **Complexidade:** O(log n)
- **Requer:** Array **obrigatoriamente ordenado**
- **Uso:** Dados ordenados, grandes volumes
- **Implementação:** Iterativa com ponteiros `esquerda` e `direita`

---

### 4. **BuscaLinearVetorOrdenado.java**
Implementação de **Busca Linear Otimizada em Vetor Ordenado**.

```java
public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract<T>
```

**Características:**
- Busca sequencial que **para antecipadamente**
- Se encontrar elemento maior que o buscado, retorna -1 (não precisa continuar)
- **Complexidade:** O(n) pior caso, mas otimizado na prática
- **Requer:** Array **obrigatoriamente ordenado**
- **Vantagem:** Mais simples que busca binária, melhor resultado com dados parcialmente encontrados

---

### 5. **TesteBuscas.java**
Classe de teste com **Plano de Testes PL01**.

**Casos de teste:**

| Caso | Operação | Entrada | Valor Buscado | Resultado Esperado |
|------|----------|---------|---------------|--------------------|
| 1 | BuscaLinear | [0,10,20,30,40,...,100] | 20 | 2 |
| 2 | BuscaLinearVetorOrdenado | [0,10,20,30,40,...,100] | 40 | 4 |
| 3 | BuscaBinaria | [0,10,20,30,40,...,100] | 70 | 7 |
| 4 | BuscaBinaria | [0,10,20,30,40,...,100] | 75 | -1 |

**Como executar:**
```bash
javac src/Lista11/Test*.java src/Lista11/Busca*.java src/Lista11/BuscaAbstract.java
java -cp src Lista11.TesteBuscas
```

---

## PARTE 2: Árvores Binárias de Busca

### 1. **NoArvoreBinaria.java**
Classe que representa um nó em uma árvore binária.

```java
public class NoArvoreBinaria<T>
```

**Atributos:**
- `info: T` - Informação armazenada no nó
- `esquerda: NoArvoreBinaria<T>` - Referência para filho esquerdo
- `direita: NoArvoreBinaria<T>` - Referência para filho direito

**Métodos:** Getters e Setters para todos os atributos

---

### 2. **ArvoreBinariaAbstract.java**
Classe abstrata base para implementações de árvores binárias.

```java
public abstract class ArvoreBinariaAbstract<T>
```

**Características:**

| Membro | Tipo | Descrição |
|--------|------|-----------|
| `raiz` | `NoArvoreBinaria<T>` | Nó raiz da árvore |
| `setRaiz()` | Protected | Define a raiz (subclasses podem sobrescrever para public) |
| `getRaiz()` | Public | Obtém a raiz |
| `estaVazia()` | Public | Verifica se a árvore está vazia |
| `buscar()` | Abstract | Método abstrato para busca |
| `pertence()` | Public | Verifica se elemento pertence à árvore, **usa obrigatoriamente `buscar()`** |
| `toString()` | Public | Representação textual em pré-ordem |
| `arvorePre()` | Private | Auxilia `toString()` com formato `<raiz<esq><dir>>` |

**Formato da String:**
- Árvore vazia: `<>`
- Árvore com nó: `<valor<esq><dir>>`
- Exemplo: `<50<30<25<><>><40<><>>><70<><>>>`

---

### 3. **ArvoreBinaria.java**
Implementação de **Árvore Binária Simples** (sem regras de ordenação).

```java
public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T>
```

**Características:**
- `setRaiz()` é público (sobrescrita)
- Busca em **profundidade (DFS)** simples
- Procura por toda a árvore sem aproveitar ordenação
- **Complexidade:** O(n)
- **Uso:** Dados sem ordenação específica

**Método de busca:**
1. Verifica se nó atual é o procurado
2. Busca recursivamente na subárvore esquerda
3. Se não encontrado, busca recursivamente na subárvore direita

---

### 4. **ArvoreBinariaBusca.java**
Implementação de **Árvore Binária de Busca (BST)**.

```java
public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T>
```

**Características:**
- Mantém propriedade BST: `esquerda < raiz < direita`
- Elementos duplicados não são inseridos
- **Complexidade média:** O(log n) para busca, inserção e remoção
- **Complexidade pior caso:** O(n) em árvores degeneradas

**Métodos principais:**

#### `inserir(T info)`
- Respeita regras de BST
- Menores valores à esquerda
- Maiores valores à direita

#### `buscar(T info)` (sobrescrita)
- Aproveita propriedades de BST
- Não busca desnecessariamente em descendentes que não contêm o valor

#### `remover(T info)`
Implementa remoção tratando 4 casos:

| Caso | Situação | Ação |
|------|----------|------|
| 1 | Nó é folha (sem filhos) | Retorna `null` (remove nó) |
| 2 | Nó tem 1 filho (direita) | Retorna filho direito |
| 3 | Nó tem 1 filho (esquerda) | Retorna filho esquerdo |
| 4 | Nó tem 2 filhos | Encontra sucessor (menor da subárvore direita), substitui valor, remove sucessor |

---

### 5. **TesteArvore.java**
Classe de teste com **Plano de Testes PL01**.

**Casos de teste:**

#### Caso 1: Inserção
```
Sequência: [50, 30, 70, 40, 25, 75, 65, 35, 60]
Resultado esperado: <50<30<25<><>><40<35<><>><>>>><70<65<60<><>><>><75<><>>>>
```

#### Caso 2: Remoção de Folha
```
Sequência: [50, 30, 25, 40]
Remove: 40 (folha)
Resultado esperado: <50<30<25<><>><>><>>
```

#### Caso 3: Remoção de Nó com 1 Filho
```
Sequência: [80, 52, 90, 48, 71, 63, 67]
Remove: 71 (tem 1 filho: 63)
Resultado esperado: <80<52<48<><>><63<><67<><>>>><90<><>>>
```

**Como executar:**
```bash
javac src/Lista11/*.java
java -cp src Lista11.TesteArvore
```

---

## Boas Práticas Implementadas

✅ **Uso de Generics:** Todas as classes usam `<T>` e `<T extends Comparable<T>>`  
✅ **Encapsulamento:** Atributos privados com getters/setters  
✅ **Herança:** Uso de classes abstratas para definir contratos  
✅ **Polimorfismo:** Métodos abstratos implementados pelas subclasses  
✅ **Documentação:** JavaDoc completo em todos os métodos  
✅ **Padrões de Projeto:** Template Method, Strategy Pattern  
✅ **Complexidade:** Análise O(n) e O(log n) explicitada  
✅ **Tratamento de null:** Verificações robustas  
✅ **Validação de entrada:** Métodos verificam argumentos nulos  

---

## Como Compilar e Executar

### Compilação
```bash
cd src
javac Lista11/*.java
```

### Execução dos Testes
```bash
# Testes de Busca
java -cp . Lista11.TesteBuscas

# Testes de Árvore
java -cp . Lista11.TesteArvore

# Exemplo do Main original
java -cp . Lista11.Main
```

---

## Diagrama de Classes

```
┌─────────────────────────────────┐
│    BuscaAbstract<T>             │
│  (Classe Abstrata)              │
│ - Object[] info                 │
│ + getInfo()                     │
│ + setInfo()                     │
│ + buscar() [Abstract]           │
└─────────┬───────────────────────┘
          │
    ┌─────┴─────┬───────────────┐
    ▼           ▼               ▼
BuscaLinear  BuscaBinaria   BuscaLinearVetorOrdenado
<T>          <T extends      <T extends
             Comparable>     Comparable>

┌──────────────────────────────────────┐
│     ArvoreBinariaAbstract<T>         │
│      (Classe Abstrata)               │
│ - NoArvoreBinaria<T> raiz            │
│ + getRaiz()                          │
│ + estaVazia()                        │
│ + buscar() [Abstract]                │
│ + pertence() [usa buscar]            │
│ + toString() [pré-ordem]             │
└──────────────────┬────────────────┬──┘
                   │                │
                   ▼                ▼
          ArvoreBinaria<T>  ArvoreBinariaBusca<T>
           (sem ordenação)   (Busca - BST)
```

---

## Validação

A solução foi validada para:
- ✅ Compilação sem erros
- ✅ Padrão Java correto
- ✅ Uso apropriado de Generics
- ✅ Conformidade com especificações do enunciado
- ✅ Casos de teste implementados

---

**Data:** 2026-06-11  
**Disciplina:** AED - Estruturas de Dados  
**Status:** ✓ Completo

