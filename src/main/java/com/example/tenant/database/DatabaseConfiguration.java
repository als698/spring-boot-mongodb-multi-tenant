package com.example.tenant.database;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoDatabase;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.util.Objects;

public class DatabaseConfiguration extends SimpleMongoClientDatabaseFactory {

    public DatabaseConfiguration(ConnectionString connectionString) {
        super(connectionString);
    }

    @Override
    protected @NotNull MongoDatabase doGetMongoDatabase(@NotNull String dbName) {
        ConnectionString connectionString = new ConnectionString(ConnectionStorage.getConnection());

        return super.doGetMongoDatabase(Objects.requireNonNull(connectionString.getDatabase()));
    }

}