Firebase all_database = new Firebase(database);
  all_database.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
          Random quoteDecision = new Random();
          int quoteselection = quoteDecision.nextInt(15);
          int quotestop = 0;
          ArrayList<Quotes> randomList = new ArrayList<>();
          for (DataSnapshot randomsnapshot : dataSnapshot.getChildren()){
              Quotes mQuotes = new Quotes(randomsnapshot.getKey(), (String) randomsnapshot.getValue()); //object to assign values
              quotestop++;
              if(quotestop == quoteselection){
                  break;
              }

          }


      }

      @Override
      public void onCancelled(FirebaseError firebaseError) {

      }
  });
