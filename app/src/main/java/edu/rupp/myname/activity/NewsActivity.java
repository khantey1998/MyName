package edu.rupp.myname.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.rupp.myname.Article;
import edu.rupp.myname.R;

public class NewsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        RecyclerView rclNews=(RecyclerView)findViewById(R.id.news_recyclerView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        rclNews.setLayoutManager(layoutManager);

        Article article1=new Article();
        article1.setTitle("Article 1");
        article1.setDate("12 Apr 2017");

        Article[] articles={article1};

        NewsAdapter adapter=new NewsAdapter();
        adapter.setArticles(articles);
        rclNews.setAdapter(adapter);
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> {
        private Article[] articles;

        public void setArticles(Article[] articles) {
            this.articles = articles;
        }

        @Override
        public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View newsViewHolderLayout= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_news,parent,false);
            ArticleViewHolder viewHolder=new ArticleViewHolder(newsViewHolderLayout);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ArticleViewHolder holder, int position) {
            Article article=articles[position];
            holder.textTitle.setText(article.getTitle());
            holder.textDate.setText(article.getDate());
        }
        @Override
        public int getItemCount() {
            return articles.length;
        }

        class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private ImageView imgThumbnail;
            private TextView textTitle;
            private TextView textDate;
            public ArticleViewHolder(View itemView)  {
                super(itemView);

                imgThumbnail= (ImageView) itemView.findViewById(R.id.img_thumbnail);
                textTitle = (TextView) itemView.findViewById(R.id.txt_title);
                textDate =(TextView) itemView.findViewById(R.id.txt_date);
            }

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NewsActivity.this, InnerNewsActivity.class);
                startActivity(intent);
            }
        }
    }

}
