create table usuario(
id number not null,
nome varchar2(200) not null,
data_cadastro date not null);

alter table usuario add constraint pk_usuario primary key(id);

create table lancamento(
id number not null,
descricao varchar2(200) not null,
valor number not null,
usuario number not null,
data_vencimento date not null,
data_cadastro date not null);

alter table lancamento add constraint pk_lancamento primary key(id);

alter table lancamento add constraint fk_lancamento_usuario foreign key(usuario) references usuario(id)

create or replace package body pck_lancamentos as
procedure processa_parcelas(p_descricao varchar2, p_usuario number, p_valor_total number, p_numero_parcelas number, p_retorno out varchar2) is
v_lancamento number;
begin
for i in 1 .. p_numero_parcelas loop
    select nvl(max(id),0)+1
      into v_lancamento
      from lancamento;
      
    insert into lancamento values (v_lancamento, p_descricao, (p_valor_total / p_numero_parcelas), p_usuario, add_months(sysdate,i), sysdate);
    
    commit;
    p_retorno := 'Parcelas processadas com sucesso!';
end loop;
exception
    when others then
    p_retorno := 'Erro ao processar parcelas - '||sqlerrm;
end;
end pck_lancamentos;

create or replace package pck_lancamentos as
procedure processa_parcelas(p_descricao varchar2, p_usuario number, p_valor_total number, p_numero_parcelas number, p_retorno out varchar2);
end pck_lancamentos;