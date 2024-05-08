2 - D)

	CREATE TABLE valores(SGBD Varchar(50), descr TEXT);
	INSERT INTO valores(SGBD, descr) VALUES(‘postgresql’, ‘PostgreSQL: Robustez para Grandes Desafios
                                        O PostgreSQL se destaca como um SGBDR robusto e confiável, ideal para projetos que exigem alto desempenho, segurança e flexibilidade.
                                        Distribuído sob licença BSD, oferece recursos avançados como herança de tabelas e triggers, além de uma comunidade ativa para suporte. 
                                        Perfeito para aplicações críticas e grandes volumes de dados.’ ),
                                        ('mysql', 'MySQL: Facilidade para o Dia a Dia
                                        O MySQL se destaca pela facilidade de uso e alto desempenho, ideal para projetos web e aplicações que exigem simplicidade e
                                        escalabilidade. Sua interface amigável e ampla gama de ferramentas facilitam o aprendizado e a administração. Altamente popular, 
                                        oferece compatibilidade com diversas ferramentas e linguagens de programação. Perfeito para quem busca praticidade e custo-benefício'),
                                        ('mariadb', 'MariaDB: Herança com Sabedoria
                                        O MariaDB se destaca como um SGBDR robusto e confiável, derivado do MySQL, ideal para quem busca familiaridade e inovação. Distribuído 
                                        sob licença GPL, oferece compatibilidade com MySQL e recursos avançados como armazenamento de colunas e visualizações materializadas.
                                        Perfeito para quem busca migração tranquila e alto desempenho.'),
                                        ('oracle', 'Oracle: Desempenho Empresarial Inigualável
                                          O Oracle se destaca como um SGBDR de alto desempenho e segurança, ideal para grandes empresas e aplicações mission-critical. 
                                          Oferece recursos avançados como particionamento de tabelas e Oracle Real Application Clusters (RAC), além de suporte robusto para 
                                          ambientes complexos. Perfeito para quem busca escalabilidade, confiabilidade e suporte de alto nível.'),
                                        ('sql_server', 'SQL Server	SQL Server: O Parceiro Microsoft para Grandes Desafios
                                        O SQL Server se destaca como um SGBDR robusto e integrado ao ecossistema Microsoft, ideal para empresas que utilizam soluções Windows. 
                                        Oferece recursos avançados como Intelligent Query Processing e Always On Availability Groups, além de integração nativa com ferramentas
                                        da Microsoft. Perfeito para quem busca alto desempenho, segurança e integração com outras soluções Microsoft.');


5 - B, C, D)

        CREATE TABLE classe(id SERIAL PRIMARY KEY, descr VARCHAR(20));
	
        CREATE TABLE aluno(ra VARCHAR(6) PRIMARY KEY, nome VARCHAR(50) NOT NULL, dt_nascimento DATE, id_classe INTEGER, FOREIGN KEY id_classe REFERENCES classe(id));
	
        INSERT INTO classe(descr) VALUES ('1º Ano'), ('2º Ano'), ('3º Ano');
	
        INSERT INTO aluno(ra, nome, dt_nascimento, id_classe) VALUES('g837cb6', 'Antonio', '05/01/2003', 2);
	
        SELECT * FROM ALUNO where id_classe 2;

7 - 

	BEGIN;

      UPDATE conta
      
      SET saldo = (select saldo where nome = 'Bruna') + 500
      WHERE bine = 'Bruna';
      UPDATE conta
      SET saldo = (select saldo where nome = 'Anna')  500
      WHERE bine = 'Anna';
    COMMIT;


