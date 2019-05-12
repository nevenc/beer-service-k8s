create table if not exists beer (
  id integer identity primary key,
  name varchar(255),
  hop varchar(255),
  yeast varchar(255),
  malt varchar(255),
  style varchar(255)
);