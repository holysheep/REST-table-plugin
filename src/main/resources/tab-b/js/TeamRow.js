jQuery.namespace("JIRA.Admin.Team.TeamRow");

JIRA.Admin.Team.TeamRow = AJS.RestfulTable.Row.extend({
    initialize: function() {
        JIRA.RestfulTable.Row.prototype.initialize.apply(this, arguments);
        this.events["click .project-config-team-delete"] = "_delete";
        this.delegateEvents();
    },
    _delete: function(e) {
        if (!confirm('Delete the team?'))
            return;
        this.model.destroy({data: this.model.toJSON()});
        e.preventDefault();
    },

    render: function() {
        alert(2);
        var data = this.model.toJSON(),
            id = this.model.get("id"),
            $el = this.$el;
        $el.attr("id", "team-" + id + "-row").attr("data-id", id);
        $el.html(JIRA.Templates.Team.teamRow({
            team: data
        }));

        return this;
    }
});