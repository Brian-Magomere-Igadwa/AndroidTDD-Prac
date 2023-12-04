package design.fiti.unitteststddclass.presentation.screen.Home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import design.fiti.unitteststddclass.R
import design.fiti.unitteststddclass.domain.models.Playlist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private var _uiState = MutableStateFlow<List<Playlist>>(emptyList())
    val uiState: StateFlow<List<Playlist>> = _uiState.asStateFlow()

    init {
        fetchPlaylists()
    }

    fun fetchPlaylists() {
        _uiState.update {
            listOf(
                Playlist("1", "Doeboy", "Trap", R.drawable.playlist),
                Playlist("1", "Future", "Hiphop", R.drawable.playlist),
                Playlist("1", "Lil Uzi", "Experimental/Hyperpop", R.drawable.playlist),
                Playlist("1", "TrippieRed", "Hyperpop", R.drawable.playlist),
                Playlist("1", "Kan Kan", "Hyperpop", R.drawable.playlist),
                Playlist("1", "Yeat", "Hyperpop/Supertrap", R.drawable.playlist),
                Playlist("1", "Wacotron", "Trap", R.drawable.playlist),
                Playlist("1", "Gherbo", "Hiphop", R.drawable.playlist),
                Playlist("1", "Southside", "Trap", R.drawable.playlist),
                Playlist("1", "Pyrex", "Trap", R.drawable.playlist)
            )
        }
    }
}