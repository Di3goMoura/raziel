# 🤖 Raziel — Assistente Pessoal de Programação

O **Raziel** é um projeto de assistente pessoal desenvolvido em Java, com o objetivo de auxiliar no aprendizado, na organização de conhecimentos e no desenvolvimento de projetos de programação.

O projeto utiliza anotações armazenadas no **Obsidian** como fonte de conhecimento, permitindo que o assistente consulte informações organizadas em arquivos Markdown.

## 🎯 Objetivo

Desenvolver um assistente capaz de compreender perguntas relacionadas à programação, identificar os assuntos envolvidos e localizar informações relevantes em uma base de conhecimento pessoal.

O Raziel está sendo construído gradualmente, com foco no aprendizado de Java, programação orientada a objetos e organização de sistemas.

## 🛠️ Tecnologias

- **Java 21** — Linguagem principal.
- **Maven** — Gerenciamento de dependências.
- **SnakeYAML** — Interpretação dos metadados YAML.
- **Obsidian** — Organização da base de conhecimento.
- **Markdown** — Formato das anotações.
- **Git e GitHub** — Versionamento do projeto.

## 🏗️ Arquitetura atual

A primeira etapa do projeto consiste na leitura e organização das anotações.

```text
Vault do Obsidian
        |
        v
    LeitorVault
        |
        v
  leitorMetadados
        |
        v
   RegistroNotas
        |
        v
  RepositorioNotas
```

### 📂 LeitorVault

Responsável por localizar arquivos Markdown dentro do Vault, incluindo arquivos armazenados em subpastas.

### 📑 leitorMetadados

Responsável por ler e interpretar os metadados YAML presentes nas anotações.

### 🗂️ RegistroNotas

Representa uma anotação encontrada, associando seu caminho aos respectivos metadados.

### 📚 RepositorioNotas

Responsável por carregar e armazenar os registros das anotações válidas em memória.

O repositório mantém os caminhos e metadados, sem carregar antecipadamente todo o conteúdo das anotações.

## 📝 Estrutura das anotações

As anotações são organizadas em arquivos Markdown com metadados YAML.

Exemplo:

```yaml
---
id: java-poo-encapsulamento
titulo: Encapsulamento
assunto: POO
categoria: conceito-central
palavrasChave:
  - encapsulamento
  - private
  - getters
  - setters
---
```

Essas informações permitirão que o Raziel identifique e localize conteúdos relacionados às perguntas do usuário.

## ✅ Funcionalidades implementadas

- Localização de arquivos Markdown no Vault.
- Busca de arquivos em subpastas.
- Leitura de metadados YAML.
- Representação individual das anotações.
- Armazenamento dos registros em memória.
- Recuperação de informações por meio de getters.
- Tratamento básico de arquivos sem delimitadores YAML.
- Testes manuais de leitura e carregamento.

## 🚧 Próximas etapas

### 🔎 LocalizadorNotas

Desenvolver um mecanismo para localizar anotações relevantes a partir de informações fornecidas pelo usuário.

### 📊 ResultadoBusca

Criar uma estrutura para representar os resultados encontrados pelo sistema de busca.

### 🧠 Interpretação de perguntas

Futuramente, implementar componentes capazes de identificar assuntos, intenções e níveis de conhecimento presentes nas perguntas.

## 📌 Status do projeto

**Em desenvolvimento.**

A primeira etapa de leitura e organização da base de conhecimento foi implementada e testada.

O próximo objetivo é desenvolver o mecanismo de busca das anotações.

---

**Raziel — Um projeto de aprendizado, evolução e construção contínua.**