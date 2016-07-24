TwitterAuthConfig authConfig =  new TwitterAuthConfig("consumer key", "cnsumer secret key");
Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());
final TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Right now I'm looking at a " + website + "!" + System.getProperty ("line.separator") + link);
                
Builder.show()  //brings up twitter
