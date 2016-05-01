INSERT INTO `belhopat_backoffice`.`LookupDetail`
(`code`,`description`,`lookup_id`)
VALUES
('ACTIVE','Active',(SELECT id FROM `belhopat_backoffice`.`Lookup` WHERE lookupKey ='CLSTATS')),
('INACTIVE','INACTIVE',(SELECT id FROM `belhopat_backoffice`.`Lookup` WHERE lookupKey ='CLSTATS'));
