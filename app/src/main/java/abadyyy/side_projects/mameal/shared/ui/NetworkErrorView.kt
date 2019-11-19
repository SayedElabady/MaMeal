package abadyyy.side_projects.mameal.shared.ui

import abadyyy.side_projects.mameal.R
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout

class NetworkErrorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
    ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        inflateLayout()
    }

    private fun inflateLayout() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.component_no_internet_view, this, true)
    }
}