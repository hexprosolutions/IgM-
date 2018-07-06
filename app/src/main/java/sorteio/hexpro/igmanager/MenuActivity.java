package sorteio.hexpro.igmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.Toast;


public class MenuActivity extends AppCompatActivity {

    private ImageView botaoBuscar;
    private ImageView botaoControle;
    private ImageView botaoCadastro;
    private ImageView botaoSaida;
    private DatabaseReference usuarioReferencia = FirebaseDatabase.getInstance().getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        botaoBuscar = (ImageView) findViewById(R.id.buscaId);
        botaoControle = (ImageView) findViewById(R.id.controleId);
        botaoCadastro = (ImageView) findViewById(R.id.cadastroId);
        botaoSaida = (ImageView) findViewById(R.id.saidaId);

        usuarioReferencia.child("NomeAve").setValue("100");



        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MenuActivity.this, BuscarActivity.class));
                AlertDialog.Builder buscarIdAve =new AlertDialog.Builder( MenuActivity.this);


                // Configuração do Dialog
                buscarIdAve.setTitle("CONSULTA AVE");
                buscarIdAve.setMessage("Codigo/Anilha");
                buscarIdAve.setCancelable(false);

                final EditText editText = new EditText(MenuActivity.this);
                buscarIdAve.setView(editText);

                //configuração dos botoes
                buscarIdAve.setPositiveButton("Consultar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String codioAnilha = editText.getText().toString();

                        // valida se o codigo/anilha foi digitado
                        if (codioAnilha.isEmpty()) {
                            Toast.makeText(MenuActivity.this, "Preencha o CODIGO/ANILHA", Toast.LENGTH_LONG).show();
                        }else {

                            // verificar se o codigo/anilha já esta cadastrado no firebase
                        }

                    }
                });
                buscarIdAve.setNegativeButton ("Cancela", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                buscarIdAve.create();
                buscarIdAve.show();


            }
        });

        botaoControle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ControleActivity.class));
            }
        });

        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, CadastroActivity.class));
            }
        });

        botaoSaida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, SaidaActivity.class));
            }
        });
    }
}
