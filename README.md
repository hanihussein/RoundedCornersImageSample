*# Version 1 *

# RoundedCornersImageSample
I create this sample to help developers to create imageview with rounded corners.


To Use It :-

First Set RoundedImageView in your Layout like this :-

<RoundedCornersImageView
    android:id="@+id/imageView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_centerInParent="true"
    android:src="@mipmap/ic_launcher"
    RoundedCornersImageView:corners="10dp" />
    
then set this line "xmlns:RoundedCornersImageView="http://schemas.android.com/apk/res-auto" in your parent layout

and And these lines in attrs file in /values. # Note if there 's no attrs file create it

<declare-styleable name="RoundedCornersImageView">

    <attr name="corners" format="dimension" />
</declare-styleable>
And Finally you can use it in your activity

private RoundedCornersImageView roundedCornersImageView;

    roundedCornersImageView = (RoundedCornersImageView) findViewById(R.id.imageView);

    roundedCornersImageView.setImageDrawable(getDrawable(R.drawable.pic_1));
