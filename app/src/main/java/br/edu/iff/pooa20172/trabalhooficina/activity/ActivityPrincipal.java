package br.edu.iff.pooa20172.trabalhooficina.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.iff.pooa20172.trabalhooficina.R;

import static java.security.AccessController.getContext;

public class ActivityPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button pecaBT = (Button) findViewById(R.id.bt_pecas);

        pecaBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PecaActivity.class);
                startActivity(intent);

            }
        });
    }

    private Context getContext(){
        return this;
    }
}
