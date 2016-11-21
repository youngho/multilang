package com.tistory.antop.framework.jstl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Map.Entry;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.tistory.antop.framework.vo.MapVo;

public class PagingTag extends RequestContextAwareTag {

	private final Logger logger = Logger.getLogger(getClass());

	private static final long serialVersionUID = 5302315433253009691L;

	private int page = 1;
	private int size = 10;
	private int total = 0;

	private int maxPage;
	private int startPage;
	private int endPage;

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	private MapVo params = new MapVo();

	public PagingTag() {
		super();

	}

	@Override
	protected int doStartTagInternal() throws Exception {

		initParam();

		StringBuffer sb = new StringBuffer();

		maxPage = total / size;
		if (total % size != 0) {
			maxPage++;
		}

		startPage = ((int) (page / size)) * size + 1;
		endPage = startPage * size;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		sb.append(getFirstLink());
		sb.append(" ");
		sb.append(getPrevLink());
		sb.append(" ");

		for (int i = startPage; i <= endPage; i++) {
			params.put("page", i);

			if (page != i) {
				sb.append("<a href=\"");
				sb.append("?");
				sb.append(getParameterString());
				sb.append("\">");
			}

			sb.append(i);

			if (page != i) {
				sb.append("</a>");
			}
			
			sb.append(" ");
		}

		sb.append(getNextLink());
		sb.append(" ");
		sb.append(getLastLink());

		JspWriter out = pageContext.getOut();
		out.write(sb.toString());

		return EVAL_BODY_INCLUDE;
	}

	private void initParam() {
		if (page < 1) {
			page = 1;
		}

		ServletRequest req = pageContext.getRequest();

		@SuppressWarnings("unchecked")
		Enumeration<String> names = req.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			params.put(name, req.getParameter(name));
		}

		params.put("page", page);
	}

	private String getParameterString() {
		return getParameterString(params);
	}

	private String getParameterString(MapVo map) {

		if (map == null) {
			map = params;
		}

		String s = "";

		int i = 0;
		for (Entry<String, Object> entry : map.entrySet()) {
			if (i > 0) {
				s += "&";
			}

			try {
				s += entry.getKey()
						+ "="
						+ URLDecoder.decode(entry.getValue().toString(),
								"UTF-8");
			} catch (UnsupportedEncodingException e) {
				logger.warn(e.getMessage());
			}

			i++;
		}

		return s;
	}

	private String getFirstLink() {
		MapVo map = (MapVo) params.clone();

		if (page > 1) {
			map.put("page", 1);

			return "<a href=\"?" + getParameterString(map) + "\">"
					+ getMessage("paging.link.first") + "</a>";
		}

		return "";

	}

	private String getPrevLink() {
		MapVo map = (MapVo) params.clone();

		if (page > 1) {
			map.put("page", page - 1);

			return "<a href=\"?" + getParameterString(map) + "\">"
					+ getMessage("paging.link.prev") + "</a>";
		}

		return "";
	}

	private String getNextLink() {
		MapVo map = (MapVo) params.clone();

		if (page < maxPage) {
			map.put("page", page + 1);

			return "<a href=\"?" + getParameterString(map) + "\">"
					+ getMessage("paging.link.next") + "</a>";
		}

		return "";
	}

	private String getLastLink() {
		MapVo map = (MapVo) params.clone();

		if (page < maxPage) {
			map.put("page", maxPage);

			return "<a href=\"?" + getParameterString(map) + "\">"
					+ getMessage("paging.link.last") + "</a>";
		}

		return "";
	}

	private String getMessage(String code) {
		return getRequestContext().getMessage(code);
	}

}
