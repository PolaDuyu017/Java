package spring4;

import spring4.board.NewArticleRequest;
import spring4.board.ReadArticleService;
import spring4.board.WriteArticleService;
import spring4.member.MemberRegRequest;
import spring4.member.MemberService;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainQuickStart2 {
	
	public static void main(String[] args){
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:acQuickStart2.xml");
		
		WriteArticleService writeArticleService =
				ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		
		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		readArticleService.read(1);
		readArticleService.read(1);
		
		
		MemberService memberService = ctx.getBean(MemberService.class);
		MemberRegRequest memberRegReq =
				new MemberRegRequest("id", "name", "pw");
		memberService.regist(memberRegReq);
		
		ctx.close();
	}
}
