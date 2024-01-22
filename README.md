# MVC CRUD Operationer

### Database commands
* create new table 'invoice'
```
create table journaldb.invoice
(
id          bigint unsigned auto_increment,
titel       varchar(100)                     not null,
datum       date default current_timestamp() not null,
beskrivning varchar(255)                     not null,
kategori    varchar(50)                      not null,
pris        decimal                          not null,
constraint id
unique (id)
);
```

