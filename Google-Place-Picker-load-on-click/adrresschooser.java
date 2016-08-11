public class addressChooser extends AppCompatActivity {
    Button local;
    Button official;
    EditText zipcode;
    int PLACE_PICKER_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_chooser);
        local = (Button)findViewById(R.id.local_button);
        official = (Button) findViewById(R.id.official_button);
        zipcode = (EditText)findViewById(R.id.zipcode_entry);





        //Listeners

    
        official.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(zipcode.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"No zipcode entered",Toast.LENGTH_SHORT).show();
                }
                else{
                    PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                    Intent intent;
                    try {
                        intent = builder.build(addressChooser.this);
                        startActivityForResult(intent, PLACE_PICKER_REQUEST);
                        System.out.println("start activity for result");
                    } catch (GooglePlayServicesRepairableException e) {
                        e.printStackTrace();
                    } catch (GooglePlayServicesNotAvailableException e) {
                        e.printStackTrace();
                    }

                }


            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this,data);


                String toastMsg = String.format("Place: %s %s", place.getName(),place.getAddress());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }
    }
}
