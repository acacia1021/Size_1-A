package com.example.a1size.fragment;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.size1.fragments.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;





    public class ProfileFragment extends Fragment {

        private final String TAG = "ProfileFragment";


        protected void queryPosts() {
            final ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
            postQuery.include(Post.KEY_USER);
            postQuery.setLimit(20);
            postQuery.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
            postQuery.addDescendingOrder(Post.KEY_CREATED_AT);
            postQuery.findInBackground(new FindCallback<Post>() {
                @Override
                public void done(List<Post> posts, ParseException e) {
                    if (e != null){
                        Log.e(TAG, "Error with query");
                        e.printStackTrace();
                        return;
                    }
                   // mPosts.addAll(posts);
                    //adapter.notifyDataSetChanged();

                    for (int i = 0; i < posts.size(); i++){
                        Post post = posts.get(i);
                        Log.d(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser().getUsername());
                    }
                }
            });
        }
    }

