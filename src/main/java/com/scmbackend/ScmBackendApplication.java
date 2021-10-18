package com.scmbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScmBackendApplication {
    public static void main(String[] args) {
        String host = "localhost";
        String port = "5432";
        String user = "postgres";
        String pass = "postgres";
        String database = "postgres_SCM";
        PostgreSQLConnection psqlc = new PostgreSQLConnection(host, port, user, pass, database);
        String prettyConsoleOutput = psqlc.getResults("SELECT * FROM distributor");
        System.out.println(prettyConsoleOutput);
        SpringApplication.run(ScmBackendApplication.class, args);
    }
}
