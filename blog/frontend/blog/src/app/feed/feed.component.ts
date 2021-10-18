import { PostService } from './../service/post.service';
import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  posts: Post[] = []
  post: Post = {} as Post

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.getPosts();
  }

  getPosts(): void {
    this.postService.getPosts().subscribe((dados: Post[]) => this.posts = dados)
  }

  publicarPost(): void {
    this.postService.addPost(this.post).subscribe(() => {
      location.assign('/feed');
    });
  }

}
