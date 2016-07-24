public void notify(View v){
    Intent intent = new Intent(this, MainActivity.class);
    PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
    Resources r = getResources();
    Notification notification = new NotificationCompat.Builder(this)
            .setTicker(r.getString(R.string.Police_kill))
            .setSmallIcon(android.R.drawable.ic_menu_report_image)
            .setContentTitle(r.getString(R.string.Police_kill))
            .setContentText(r.getString(R.string.Police_kill2))
            .setContentIntent(pIntent)
            .setAutoCancel(true)
            .build();

    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    notificationManager.notify(0, notification);
}
