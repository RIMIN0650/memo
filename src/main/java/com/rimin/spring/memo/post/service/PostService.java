package com.rimin.spring.memo.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rimin.spring.memo.common.FileManager;
import com.rimin.spring.memo.post.domain.Post;
import com.rimin.spring.memo.post.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post addPost(int userId, String title, String contents, MultipartFile file) {
		// 로그인 성공하면 id 멤버변수가 세션에 저장해뒀음
		// 로그인 상태 사용자가 현재 작성자
		
		
		// file을 특정 경로에 저장한다.
		// 클라이언트에서 접근 가능한 url 정보를 얻는다.
		String imagePath = FileManager.saveFile(userId, file);
		
		Post post = Post.builder()
					// .뒤가 멤버변수 이름 괄호 안이 parameter 로 전달받는 값
					.userId(userId)
					.title(title)
					.contents(contents)
					.imagePath(imagePath)
					.build();
		return postRepository.save(post);
		// save : 그 행의 data 를 entity 클래스 객체로 return 
	}
	
	public List<Post> getPostList(int userId){
	// 특정 사용자의 메모 목록을 돌려줌
		return postRepository.findByUserIdOrderByIdDesc(userId);
	}

	//일치하는 아이디 게시물 정보 리턴
	public Post getPost(int id) {
		// primary 키 기반으로 조회하는
		// 딱 한 행만 지칭해서 리턴하는건 optional로 한번 감싸진 객체가 전달됨
		Optional<Post> optionalPost = postRepository.findById(id);
		// 안정적으로 리턴하기 위해 리턴된 값이 null 일 경우가 있으므로 optional 객체 리턴함으로써
		// null 생겼을때 명확하게 처리하기 위함
		
//		Post post = optionalPost.orElse(null);
//		return post;
		return optionalPost.orElse(null);
		
	}
	
	// 메모 수정
	public Post updatePost(int id, String title, String contents){
		// jpa update
		// 수정 대상 데이터 조회 > 조회 결과는 객체 형태로 전달 > 조회된 객체에서 필요한 값 수정 > 해당 객체를 저장
		Optional<Post> optionalPost = postRepository.findById(id);
		Post post = optionalPost.orElse(null);
		
		if(post != null) {
			post = post.toBuilder()
				.title(title) // .객체의 멤버변수 이름 (멤버변수에 저장할 값 파라미터로 전달받음)
				.contents(contents) // .객체의 멤버변수 이름 (멤버변수에 저장할 값 파라미터로 전달받음)
				.build();

			post = postRepository.save(post);
		}
		return post;
	}
	
	// 게시글 삭제
	public Post deletePost(int id){
		// 대상이 되는 게시글 정보 얻어오고
		// 확인 후 그 정보 삭제
		
		Optional<Post> optionalPost = postRepository.findById(id);
		Post post = optionalPost.orElse(null);
		
		if(post != null) {
			FileManager.removeFile(post.getImagePath());	
			postRepository.delete(post);
		}
		return post;
	}
	
	
	
	
	
	
	
	
	
}
