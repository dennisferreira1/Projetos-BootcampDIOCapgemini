import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Post } from '../model/post';

const url = "http://localhost:3000/posts"

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) {

  }

  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(url)
  }

  addPost(post: Post): Observable<any> {
    return this.http.post(url, post);
  }
}
