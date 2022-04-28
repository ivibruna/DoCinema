package es.usj.ibruna.docinema.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import es.usj.ibruna.docinema.R

import es.usj.ibruna.docinema.data.Movie
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_item.view.*
class MovieAdapter(list: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    var movieList: ArrayList<Movie> = arrayListOf()
    init {
        movieList.addAll(list)
    }

    class MovieHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun render(movie: Movie) {
            view.movie_title.text = movie.title
            view.movie_release_date.text = movie.year.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieHolder(layoutInflater.inflate(R.layout.movie_item, parent, false))
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieHolder, position: Int) {
        holder.render(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}
/*class MovieAdapter(private val context:Context, private val arrayList:ArrayList<Movie>):BaseAdapter(){
    private lateinit var movieTitle: TextView
    private lateinit var movieYear: TextView
     override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    /*class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bindMovie(movie : Movie){
            itemView.movie_title.text = movie.title
            itemView.movie_release_date.text = movie.year.toString()
        }
    }
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }*/

    override fun getView(p0: Int, p1: View?, p2: ViewGroup): View? {

        var convertView = p1
        convertView = LayoutInflater.from(p2.context).inflate(R.layout.movie_item, p2, false)
        movieTitle = convertView.findViewById(R.id.movie_title)
        movieYear = convertView.findViewById(R.id.movie_release_date)
        movieTitle.text = arrayList[p0].title
        movieYear.text = arrayList[p0].year.toString()
        return convertView
    }

}*/


