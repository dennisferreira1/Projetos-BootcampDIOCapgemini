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
  nomeBusca: string = '';
  qtdPostsPorPagina = 5;
  pagina = 0;
  carregarMais= true;

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.getPosts();
  }

  getPosts(): void {
    this.postService.getPosts(this.qtdPostsPorPagina, ++this.pagina, this.nomeBusca).subscribe((dados: Post[]) => {
      if(dados.length != 0) {
        this.posts.push(...dados);
        this.carregarMais = true;
      } else {
        this.carregarMais = false;
      }
    })
  }

  publicarPost(): void {
    this.postService.addPost(this.post).subscribe(() => {
      location.assign('/feed');
    });
  }

  getPostsPorNome(nome: string): void {
    this.nomeBusca = nome;
    this.pagina = 0;
    this.postService.getPosts(this.qtdPostsPorPagina, ++this.pagina, this.nomeBusca).subscribe((dados: Post[]) => {
      if(dados.length != 0) {
        this.posts = dados;
        this.carregarMais = true
      } else {
        this.carregarMais = false;
      }
    })
  }

}
