# 🧮 Calculadora de Expressões com Números Complexos em Notação Lisp 

> Contexto
Trabalho acadêmico – Implementação de um interpretador de expressões com números complexos usando notação Lisp e árvores sintáticas


## Funcionalidades
Funcionalidades

- Representação de números complexos no formato a + bi.

- Operações suportadas: +, -, *, /, conj, ^ (potência), raiz (sqrt).

- Construção de árvore sintática (AST) a partir da expressão.

- Execução da expressão via avaliação recursiva da árvore.

- Impressão da árvore com indentação.

- Verificação de igualdade entre duas expressões.

- Entrada de variáveis: o programa solicita valores quando necessário.

- Detecção de erros: parênteses incorretos, operadores inválidos, argumentos faltando, divisão por zero, uso incorreto de complex, etc.

## Como utilizar
Ao inicar o programa ele irá exibir três opções:

- opção [1] - Calcular Expressão LISP
  Ao colocar uma expressão LISP, ex:
  ```bash
  (+ (* (complex 2 3) (complex 4 5)) (- (complex 10 -2) (complex 3 1)))
  ```
  
- opção [2] - Calculadora Inteligente
  Ao dar o valor dos números complexos que irá calcular, ela vai ter perguntar qual operação quer fazer, assim gerando um novo Z como resposta.

- opção [3] - Verificação de Igualdade
  O programa irá pedir duas expressões lisp como entrada e te dirá caso elas sejam estruturalmente iguais ou não. Ex:
  Expressão 1:
  ```bash
  (+ (complex 1 2) (complex 3 4))
  ```
  Expressão 2:
  ```bash
  (+ (complex 3 4) (complex 1 2))
  ```

## Como executar (VisualStudioCode)

1. Clone o repositório:
```bash
git clone https://github.com/A3-Estrutura-de-dados-e-algoritmos/calculadora-complexa.git
```

2. Compilar:
```bash
javac -encoding UTF-8 -cp "libs/*" *.java -d out
```

3. Executar:
```bash
java -cp "out;libs/*" main
```

## Componentes do Grupo:
- Victor Botto Silva Passos - 12724130769
- Paulo Victor Nonato de Jesus - 12724129348
- Rafael Silva Rangel de Almeida – 1272412932
