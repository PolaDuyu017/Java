package controller;

import service.ArticleService;
import service.NewArticleCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/article/newArticle.do")
public class NewArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(){
		return "article/newArticleForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command){
		articleService.writeArticle(command);
		return "article/newArticleSubmit";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
}
