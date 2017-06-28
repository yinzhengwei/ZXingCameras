# ZXingCameras
二维码识别和二维码生成

zxing应该说是一个比较老得且非常成熟的二维码框架了！里面利用SurfaceView进行图像捕获，主要功能分为二维码识别和二维码的生成。

二维码的识别用法：
//在需要调起扫码相机的地方启动：
startActivityForResult(new Intent(getApplicationContext(), CaptureActivity.class), 0);
//然后在activity界面中重写回调方法进行接收结果值：
@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            Toast.makeText(getApplicationContext(), bundle.getString("result"), Toast.LENGTH_SHORT).show();
        }
    }
    
    
二维码的生成用法：
//logoBitmap表示的是二维码中间的logo图片,这里得500是设置的宽和高
Bitmap logoBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
Bitmap bitmap = EncodingUtils.createQRCode("http://github.com", 500, 500, logoBitmap);
iv_camrea.setImageBitmap(bitmap);

//如果不想要中间的logo图片，则不需要设置即可：
Bitmap bitmap = EncodingUtils.createQRCode("http://github.com", 500, 500, null);
iv_camrea.setImageBitmap(bitmap);
