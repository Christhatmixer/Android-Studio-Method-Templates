science_button = (ImageButton) findViewById(R.id.science_button);


final Animation shake = AnimationUtils.loadAnimation(this, R.anim.animation1);
science_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(final View v) {
        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent subject = new Intent(v.getContext(),MainActivity.class);
                subject.putExtra("subject","Science");
                startActivity(subject);



            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        science_button.startAnimation(shake);
