package br.edu.iff.pooa20172.trabalhooficina.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20172.trabalhooficina.R;
import br.edu.iff.pooa20172.trabalhooficina.model.Proprietario;
import io.realm.Realm;

public class ProprietarioDetalheActivity extends AppCompatActivity {

    EditText nome, endereco, telefone;
    Button btsalvar,btalterar, btdeletar;

    int id;
    Proprietario proprietario;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proprietario_detalhe);

        nome = (EditText) findViewById(R.id.ed_nome_proprietario);
        endereco = (EditText) findViewById(R.id.ed_endereco);
        telefone = (EditText) findViewById(R.id.ed_telefone);

        btsalvar = (Button) findViewById(R.id.bt_salvar_servico);
        btalterar = (Button) findViewById(R.id.bt_alterar_servico);
        btdeletar = (Button) findViewById(R.id.bt_deletar_servico);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            proprietario = realm.where(Proprietario.class).equalTo("id",id).findFirst();

            nome.setText(proprietario.getNome());
            endereco.setText(proprietario.getEndereco());
            telefone.setText(proprietario.getTelefone());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        proprietario.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietário deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Proprietario.class).max("id") !=null)
            proximoID = realm.where(Proprietario.class).max("id").intValue()+1;

        realm.beginTransaction();
        Proprietario proprietario = new Proprietario();
        proprietario.setId(proximoID);
        proprietario.setNome(nome.getText().toString());
        proprietario.setEndereco(endereco.getText().toString());
        proprietario.setTelefone(telefone.getText().toString());

        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietário Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();

        proprietario.setNome(nome.getText().toString());
        proprietario.setEndereco(endereco.getText().toString());
        proprietario.setTelefone(telefone.getText().toString());

        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietário Alterado", Toast.LENGTH_LONG).show();
        this.finish();

    }

}

