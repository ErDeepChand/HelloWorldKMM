import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainVIewModel : ViewModel() {
    private val _greeting: MutableStateFlow<List<String>> =  MutableStateFlow(listOf())
    val greeting = _greeting.asStateFlow()

    init {
        viewModelScope.launch {
            Greeting().greet().collect{
                phrase -> _greeting.value += phrase
            }
        }
    }

}