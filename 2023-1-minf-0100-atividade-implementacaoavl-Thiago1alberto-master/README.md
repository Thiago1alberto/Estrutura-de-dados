[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-8d59dc4de5201274e310e4c54b9627a8934c3b88527886e3b421487c677d23eb.svg)](https://classroom.github.com/a/paVUpt7r)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=10549279&assignment_repo_type=AssignmentRepo)
# Apresentação da Atividade
<img src="assets/images/Unicap_Icam_Tech-01.png" alt="drawing" width="250"/>

## Identificação
**Disciplina**: Estrutura de Dados II
\
**Atividade**: Implementação Árvore AVL
- [@mjcea - Prof. Marcos Canêjo](marcos.azevedo@unicap.br)

## Instruções
- Sua implementação deve estar dentro da pasta src/**main**/java 
- Não modifique nenhum código dentro da pasta src/**test**/java
- *Commits* fora do prazo **serão completamente desconsiderados**

##  Descrição
Implemente a ``Árvore AVL`` com o fator de balanceamento ``alturaDireita - alturaEsquerda`` e na remoção ``substituir o vertice pelo maior da esquerda`` de acordo com a seguinte assinatura:
```java
public class FilaEstatica {
  private No raiz;

  public void put(Integer chave){}
  public Integer get(Integer chave){}
  private No rotacaoEsquerda(No y){}
  private No rotacaoDireita(No y){}
  public int altura(No no){}
  private No balancear(No no){}
}

public class No {
    public final Integer chave;
    public int altura;
    public No direita;
    public No esquerda;

    public No(Integer chave){}
}

```