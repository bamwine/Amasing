package innocat.amasing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity implements View.OnClickListener{

    TextView cart,buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_product_details);
        cart = (TextView)findViewById(R.id.addcat);
        buy = (TextView)findViewById(R.id.addbuy);
        cart.setOnClickListener(this);
        buy.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.pro_list) {

            startActivity(new Intent(this,Categores.class));
            return true;
        }

        if (id == R.id.cart_list) {
            startActivity(new Intent(ProductDetails.this,Cart.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){

           case R.id.addcat:

               break;
           case R.id.addbuy:
               break;


       }
    }
}
