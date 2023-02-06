package innocat.amasing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;

public class Categores extends AppCompatActivity {
    ListView list;
    // TextView cont,desc;
    ImageView icon;
    CustomViewAdd adapter;
    EditText editsearch;

    ArrayList<Customload> myList = new ArrayList<Customload>();

    String [] products =new String[] {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE"};

    int  []images = new int[] {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_categores);
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.bams), iconFont);


        list=(ListView)this.findViewById(R.id.list_view);

        getDataInList();
        adapter=   new CustomViewAdd(Categores.this, myList);
        list.setAdapter(adapter);
        list.setTextFilterEnabled(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

               // CustomViewAdd item = (CustomViewAdd) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent(Categores.this, ProductList.class);
               // intent.putExtra("title", item.getTitle());
                //intent.putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);

            }
        });



        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.inputSearch);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                //Categores.this.adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence cc, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub



            }
        });




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


            return true;
        }

        if (id == R.id.cart_list) {
            startActivity(new Intent(Categores.this,Cart.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void getDataInList() {
        for (int i = 0; i < products.length; i++) {
            // Create a new object for each list item
            Customload ld = new Customload();
            ld.setIcon(images[i]);
            ld.setTile(products[i]);
            ld.setDesc(products[i]);

            // Add this object into the ArrayList myList
            myList.add(ld);
        }
    }



    class CustomViewAdd extends BaseAdapter {

        ArrayList<Customload> myList = new ArrayList<Customload>();
        LayoutInflater inflater;
        Context context;

        public CustomViewAdd() {
        }

        public CustomViewAdd(Context context, ArrayList<Customload> myList) {
            this.myList = myList;
            this.context = context;
            inflater = LayoutInflater.from(this.context);

        }


        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Customload getItem(int position) {
            return myList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView tvTitle, tvDesc;
            ImageView ivIcon;

            if (convertView==null) {

                convertView = inflater.inflate(R.layout.list_row, parent, false);
            }
            tvTitle = (TextView) convertView.findViewById(R.id.title);
            tvDesc = (TextView) convertView.findViewById(R.id.artist);
            ivIcon = (ImageView) convertView.findViewById(R.id.icon);


            Customload currentListData = getItem(position);
            tvTitle.setText(currentListData.getTile());
            tvDesc.setText(currentListData.getDesc());
          //  ivIcon.setImageResource(currentListData.getIcon());

            return convertView;
        }
    }

    public class Customload {

        String desc,tile;
        int icon;
        public Customload() {

        }
        public Customload(int icon, String tile, String desc) {
            this.icon = icon;
            this.tile = tile;
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getTile() {
            return tile;
        }

        public void setTile(String tile) {
            this.tile = tile;
        }

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }
    }



}
