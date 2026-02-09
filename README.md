# EASTER_EGG_URLS

# HtmlAnalyzer

Analisador de HTML que encontra o texto no nível mais profundo de aninhamento de uma página web.

## Como usar

### Compilar

```bash
javac *.java
```

### Executar

```bash
java HtmlAnalyzer <URL>
```

**Exemplo:**

```bash
java HtmlAnalyzer http://hiring.axreng.com/internship/example1.html
```

## Estrutura do Projeto

- `HtmlAnalyzer.java` - Classe principal
- `HtmlFetcher.java` - Busca o conteúdo HTML de uma URL
- `HtmlParser.java` - Analisa o HTML e encontra o texto mais profundo
- `MalformedHtmlException.java` - Exceção para HTML malformado

## Saídas

- **Sucesso:** Imprime o texto encontrado no nível mais profundo
- **HTML malformado:** `malformed HTML`
- **Erro de conexão:** `URL connection error`
