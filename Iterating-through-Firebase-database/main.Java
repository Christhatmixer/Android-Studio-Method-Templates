//Assumes you have Firebase fully setup for your project. 

/*
assumes database looks like

Something
    name1: "Whatever1"
    name2: "whatever2"
    name3: "whatever3"
*/




@Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      Firebase.setAndroidContext(this);
      Firebase database = new Firebase("Database URL");

      database.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              for (DataSnapshot quotesnapshot : dataSnapshot.getChildren()){
                  String name = (String) quotesnapshot.getKey();
                  String quote =(String) quotesnapshot.getValue();
                  
                  

                  System.out.println(name + " " + quote);
                  
                  /* prints
                  name1  what1
                  name2  what2
                  */
              }

          }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());


            }
        });
