package matteo.threadapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        EditText numero = (EditText) findViewById(R.id.numberEditText);
        int n = Integer.parseInt(numero.getText().toString());
        Log.d("onClick", "Primo.execute");
        new Primo().execute(n);
    }

    private class Primo extends AsyncTask<Integer, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Perform pre-adding operation here.
        }
        @Override
        protected Boolean doInBackground(Integer...n) {
            Log.d("backGround", "execute");
            Boolean ve = false;
            int num = Integer.parseInt(n[0].toString());
            for (int i=2; i<num-1; i++){
                if(num%i == 0){
                    ve=true;
                }
            }
            return ve;
        }
        @Override
        protected void onPostExecute(Boolean B) {
            Log.d("onPost", "execute");
            final TextView numberTexView = (TextView) findViewById(R.id.numberView);
            if(!B)
                numberTexView.setText("Primo!");
            else
                numberTexView.setText("Non primo");
            //To after addition operation here.
        }
    }
}
