package abadyyy.side_projects.mameal.data.ui.bindingadapters


import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter(value = ["imageUrl", "imageUrlPlaceholder"], requireAll = false)
fun setImgURL(imageView: ImageView, imageUrl: String?, placeholder: Any?) {
    Glide
        .with(imageView.context)
        .load(imageUrl)
        .run {
            when (placeholder) {
                is Int -> this.apply(RequestOptions()
                    .placeholder(placeholder)
                    .error(placeholder))
                is Drawable -> this.apply(RequestOptions()
                    .placeholder(placeholder)
                    .error(placeholder))
                else -> this
            }
        }
        .into(imageView)
}
