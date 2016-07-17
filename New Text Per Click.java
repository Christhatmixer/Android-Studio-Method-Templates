int count = 0;
public void ButtonOnClick(View v){
    count += 1;
    TextView textview = (TextView) findViewById(R.id.textview);
    if (count == 1){
        *Name of Text View*.setText("Im text 1");
    }
    else if(count == 2){
        *Name of Text View*.setText("Im text 2");
    }
    else if(count == 3){
        *Name of Text View*.setText("Im text 3");
        count =0;
    }
  }
