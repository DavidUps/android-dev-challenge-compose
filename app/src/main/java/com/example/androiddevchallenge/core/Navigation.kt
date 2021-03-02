import androidx.navigation.NavBackStackEntry
import com.example.androiddevchallenge.model.Puppy
import com.google.gson.Gson

fun NavBackStackEntry.getPuppy() =
    this.arguments?.getString("puppy")?.let {
        Gson().fromJson(it, Puppy::class.java)
    }