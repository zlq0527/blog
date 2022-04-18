package com.myblog.blog.utility;

import com.myblog.blog.model.BlogComment;
import com.vdurmont.emoji.EmojiParser;

import java.util.List;

/**
 * ClassName:EmojiUtility
 * Package:com.myblog.blog.utility
 * Description:
 *
 * @Date:2020/7/31 20:52
 * @com.chuangmei
 */
public class EmojiUtility {

	public static String convertEmojiToStr(String source) {
		return EmojiParser.parseToAliases(source);
	}

	public static void convertStrToEmoji(List<BlogComment> comments) {
		for (BlogComment comment : comments) {
			comment.setContent(EmojiParser.parseToUnicode(comment.getContent()));
		}
	}

}
