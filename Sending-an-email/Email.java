Log.i("Send email", "");

String[] TO = {"theelitelabel@gmail.com"};
Intent emailIntent = new Intent(Intent.ACTION_SEND);
emailIntent.setData(Uri.parse("mailto:"));
emailIntent.setType("text/plain");


emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

try {
    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    finish();
    Log.i("Finished sending email", "");
} catch (android.content.ActivityNotFoundException ex) {
    Toast.makeText(MainActivity.this,
            "There is no email client installed.", Toast.LENGTH_SHORT).show();
}
