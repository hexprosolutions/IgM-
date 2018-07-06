package sorteio.hexpro.igmanager;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity {

    private String [] permissoesNecessarias = new String[]{
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA

    };

    private ImageView botaoAbrirGaleria;
    private static final int SELECAO_GALERIA = 100;
    private ImageView imagemPerfil;
    private RadioGroup sexoAve;
    private Button btCadastrar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        botaoAbrirGaleria = (ImageView) findViewById(R.id.botaoGaleria);
        imagemPerfil = (ImageView) findViewById(R.id.imageViewPerfil);
        sexoAve = (RadioGroup) findViewById(R.id.rgSexo);
        btCadastrar = ( Button) findViewById(R.id.botaoCadastroAve);




    // buscar imagens da galeria
        botaoAbrirGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (i.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(i, SELECAO_GALERIA);
                }

            }
        });
    }
    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data){
        super.onActivityResult( requestCode, resultCode, data);

        if ( resultCode == RESULT_OK){
            Bitmap imagem = null;

            try{
                switch ( requestCode ) {
                    case SELECAO_GALERIA:
                        Uri localImagemSelencionada = data.getData();
                        imagem = MediaStore.Images.Media.getBitmap(getContentResolver(), localImagemSelencionada);
                        break;
                }
                if ( imagem != null){
                    imagemPerfil.setImageBitmap( imagem);
                }
            } catch ( Exception e ){
                 e.printStackTrace();
            }

        }
    };
    /* botao cadatrar firebase
    public void  verificaRadioButton() {
        sexoAve.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (i == R.id.idMacho) {
                    resultadoSexo.setText("Macho");
                } else {
                    resultadoSexo.setText("Fêmea");
            }
        });

        }
    }*/


}
